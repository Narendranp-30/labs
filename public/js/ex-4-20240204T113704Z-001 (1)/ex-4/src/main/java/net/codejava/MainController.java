package net.codejava;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> woodList = Arrays.asList("Mcq", "Written", "Online");
        model.addAttribute("woodList", woodList);
        List<String> productList = Arrays.asList("Cs", "Mat", "Phy","Chem");
        model.addAttribute("productList", productList);
        List<String> amountList = Arrays.asList("60", "80", "100","120");
        model.addAttribute("amountList", amountList);

		
		return "register_form";
	}
	
	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult, Model model) {
		System.out.println(user);
		
		if (bindingResult.hasErrors()) {
			List<String> woodList = Arrays.asList("Mcq", "Written", "Online");
        model.addAttribute("woodList", woodList);
        List<String> productList = Arrays.asList("Cs", "Mat", "Phy","Chem");
        model.addAttribute("productList", productList);
        List<String> amountList = Arrays.asList("60", "80", "100","120");
        model.addAttribute("amountList", amountList);

			
			return "register_form";
		} else {
			return "register_success";
		}
	}
}
