package com.emusicstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;
import com.emusicstore.service.CartItemService;
import com.emusicstore.service.CartService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartRestService {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	@ResponseBody
	public Cart getCartById(@PathVariable("cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser) {

		Customer customer = customerService.getCustomerByUserName(activeUser.getUsername());

		Cart cart = customer.getCart();

		Product product = productService.getProductById(productId);

		if (cart.productExists(product)) {
			// just update the quantity
			CartItem item = cart.getCartItemByProduct(product);
			item.setQuantity(item.getQuantity() + 1);
			item.setTotalPrice(item.getTotalPrice() * item.getQuantity());

			cartItemService.addCartItem(item);
		} else {
			// add a new product
			CartItem item = new CartItem(product);
			item.setQuantity(1);
			item.setTotalPrice(product.getProductPrice());
			item.setCart(cart);
			cartItemService.addCartItem(item);
		}

	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser) {

		CartItem item = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(item);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {

		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItem(cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientErrors(Exception e) {
		// do nothing
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server")
	public void handleServerErrors(Exception e) {
		// do nothing
	}

}
