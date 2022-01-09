package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.GoodsType;
import com.star.entity.Role;
import com.star.mapper.GoodsTypeMapper;


@Controller
public class GoodTypeController {

	@Autowired
	private GoodsTypeMapper gtm;
	
	@RequestMapping("/GoodsTypeList")
	public String findAllGoodsType(HttpServletRequest request) {
		List<GoodsType> listGT = gtm.findAll();
		request.setAttribute("list", listGT);
		return "/goodsTypeList";
	}
	@RequestMapping("/GoodsTypeModify")
	public String GoodsTypeModify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		//获取保存时的参数
		String act = request.getParameter("act");
		//判断(是点击的保存还是其他，(act是保存))
		if (act == null) {
					
			//判断(打开时是修改删除还是编辑)
			if ("d".equals(flag)) {
				//删除(调用根据id删除的方法)
				gtm.deleteGoodsType(id);
				return "redirect:/GoodsTypeList";
			} else {
				if (id == null) {
					//添加(转发到添加界面)
				} else {
					//修改
					GoodsType gt = gtm.getGoodsTypeById(id);
					//获取的id添加到type
					request.setAttribute("type", gt);
				}
				//转发到编辑界面
				return "goodsTypeForm";
			}

		}	else {
			//获取保存时传递的数据
			String tid = request.getParameter("tid");
			String name = request.getParameter("name");
			//创建对象 保存值
			GoodsType gt=new GoodsType();
			gt.setTid(tid);
			gt.setName(name);
			//保存 添加
			if ("add".equals(act)) {
				//调用添加的方法
				int i = gtm.addGoodsType(gt);
						
			} else if ("mdy".equals(act)) {
				//保存时是修改
				//调用修改的方法
				int i = gtm.updateGoodsType(gt);
				//转发到查询所有商品类别的地址
			}
			//请求到重新查询所有类别的servlet（如果有参数直接跳转到主界面GoodsTypeList 重新查询）
			return "redirect:/GoodsTypeList";
		}
	}
}



