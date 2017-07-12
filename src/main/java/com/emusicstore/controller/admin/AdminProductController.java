package com.emusicstore.controller.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.model.Product;
import com.emusicstore.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	private ProductService productService;
	private Path path;

	/**
	 * Get method that redirects to add product view
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");

		model.addAttribute("product", product);

		return "addProduct";
	}

	/**
	 * Same path as addProduct but using post instead, add product in db
	 * 
	 * @param product
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute Product product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		System.out.println("adding product : " + product);
		productService.addProduct(product);

		// TODO: save the image in db instead since it's not working locally
		saveImageInLocalFolder(product, request);

		// redirect to another controller
		return "redirect:/admin/productInventory";
	}

	private void saveImageInLocalFolder(Product product, HttpServletRequest request) {
		MultipartFile productFile = product.getProductImage();
		String root = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(root + "\\WEB-INF\\resources\\image\\" + product.getId() + ".png");

		if (null != productFile && !productFile.isEmpty()) {
			try {
				productFile.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("exception saving image ", e);
			}
		}
	}

	@RequestMapping("/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, HttpServletRequest request) {
		System.out.println("deleting product id: " + id);

		deleteImageInLocalFolder(id, request);

		// TODO: move the image to db since it's not working locally
		// remove the image
		productService.deleteProduct(id);

		return "redirect:/admin/productInventory";
	}

	private void deleteImageInLocalFolder(int id, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(root + "\\WEB-INF\\resources\\image\\" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("exception deleting image ", e);
			}
		}
	}

	/**
	 * Gets all info from db and redirects to edit product view
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/productInventory/editProduct/{id}")
	public String editProduct(@PathVariable int id, Model model) {

		Product product = productService.getProductById(id);
		model.addAttribute("product", product);

		return "editProduct";
	}

	/**
	 * Save the modifications of the product in db
	 * 
	 * @param product
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/productInventory/editProduct/{id}", method = RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute Product product, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		productService.editProduct(product);

		// TODO: move the image to db since it's not working locally
		editImageInLocalFolder(product, request);

		return "redirect:/admin/productInventory";
	}

	private void editImageInLocalFolder(Product product, HttpServletRequest request) {
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("Product image saving failed", e);
			}
		}
	}
}
