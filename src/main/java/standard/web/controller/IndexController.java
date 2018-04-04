package standard.web.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import standard.entity.Standard;
import standard.service.ServiceException;
import standard.service.StandardService;

@Controller
public class IndexController {

	@Autowired
    private StandardService sts;
	
	@RequestMapping("/list")
	public String index(Model model,String title,Integer pageNumb) {
		int pageSzie=2;
		
		if(pageNumb==null) {
			pageNumb=1;
		}
		int nu=sts.getNum(title);
		nu=nu%pageSzie==0?nu/pageSzie:nu/pageSzie+1;
		System.out.println(pageNumb);
		model.addAttribute("stabdard", sts.getStan(title, pageNumb, pageSzie));
		model.addAttribute("numb",nu);
		model.addAttribute("title", title);
		model.addAttribute("pageNumb",pageNumb);
		return "list";		
	}
	
	@RequestMapping("/addsys")
	public String  addModify(Model model,Integer id) {
		if(id!=null) {
			model.addAttribute("stan", sts.fechByid(id));
		}
		return "addsys";
	}
	
	@RequestMapping("delete")
	public String  name(int[] vehicle,Model model) {
		try {
			sts.delete(vehicle);
			model.addAttribute("erre", "删除成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("erre", e.getMessage());		
		}
		return "redirect:/list";
	}
	
	
}
