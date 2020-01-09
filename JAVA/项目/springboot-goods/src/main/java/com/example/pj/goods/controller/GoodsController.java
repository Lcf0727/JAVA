package com.example.pj.goods.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pj.goods.pojo.Goods;
import com.example.pj.goods.service.GoodsService;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	/**请求商品信息，并将商品信息转换为json格式的字符串，然后响应到客户端*/
	@RequestMapping("/dofindGoods")
	@ResponseBody
	public List<Goods> dofindGoods() throws Exception{
		Thread.sleep(2000);
		Map<String, Object> map = goodsService.findGoods();
		List<Goods> list= (List<Goods>) map.get("data");
		return list;
	}
	/**ajax添加一个goods*/
	@RequestMapping("/doSaveGoods")
	@ResponseBody
	public String doSaveGoods(Goods entity) {
		goodsService.saveObject(entity);
		return "save ok";
	}
	/**ajax删除一个goods*/
	@RequestMapping("/doDeleteGoods")
	@ResponseBody
	public String doDeleteGoods(Integer id) {
		goodsService.deleteById(id);
		return "delete ok";
	}
	/**返回goods-ajax商品页面*/
	@RequestMapping("/doGoodsUI")
	public String doGoodsUI(){
		//return "goods-ajax";
		return "goods-jquery-ajax";
	}
	
	
	/*------------------下面是thymeleaf同步操作--------------------------------*/
	/**返回goos商品页面*/
	@RequestMapping("/dofindGoods2")
	public String dofindGoods2(Model model) throws Exception{
		model.addAttribute("map", goodsService.findGoods());
		return "goods";
	}
	/**删除一个goods*/
	@RequestMapping("/doDeleteById")
	public String doDeleteById(Integer id){
		goodsService.deleteById(id);
		return "redirect:/dofindGoods2";
	}
	/**添加一个goods*/
	@RequestMapping("/doSaveObject")
	public String doSaveObject(Goods entity){
		goodsService.saveObject(entity);
		return "redirect:/dofindGoods2";
	}
}
