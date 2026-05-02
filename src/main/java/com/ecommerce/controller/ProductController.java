package com.ecommerce.controller;
import com.ecommerce.model.Product;
import com.ecommerce.repo.ProductRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
private final ProductRepo repo;
public ProductController(ProductRepo repo){this.repo=repo;}

@GetMapping("/")
public String home(Model model){
model.addAttribute("products", repo.findAll());
return "index";
}

@PostMapping("/add")
public String add(@RequestParam String name,@RequestParam double price){
repo.save(new Product(name,price));
return "redirect:/";
}
}