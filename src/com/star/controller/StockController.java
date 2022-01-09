package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Stock;
import com.star.mapper.CustomMapper;
import com.star.mapper.StockMapper;


@Controller
public class StockController {
	@Autowired
	private StockMapper sm;
	@Autowired
	private CustomMapper cm;
	
	@RequestMapping("/StockList")
	public String findAllStock(HttpServletRequest request) {
		List<Stock> listpv = sm.findAll();
		request.setAttribute("list", listpv);
		return "/stockList";
	}
	@RequestMapping("/StockModify")
	public String StockModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		//��ȡ�ж����name��ֵ
		String act=request.getParameter("act");
		List<Custom> list=cm.selectCustomByType(2);
		//����
		request.setAttribute("provider", list);
		//ɾ��
		if (flag!=null) {
			//���ø���idɾ���ķ���
			sm.deleteStock(id);
			//ת��
			return "redirect:/StockList";
		}
		//�ж�(�ǵ���ı��滹������)
		if (act==null) {
			
			if(id==null) {
				//���
			}else{
				//�޸�
				Stock s=sm.findById(id);
				request.setAttribute("stock", s);
			}
			//ת�����༭����
			return "stockForm";
			
		}else {
			
			//��ȡ����ʱ���ݵ�����
			String sid=request.getParameter("sid");
			String cid=request.getParameter("cid");
			String date=request.getParameter("date");
			double totalprice=Double.parseDouble(request.getParameter("totalprice"));
			String buyer=request.getParameter("buyer");
			//ʵ����Stock
			Stock s=new Stock();
			s.setSid(sid);
			//ʵ����custom
			Custom ce=new Custom();
			ce.setCid(cid);
			s.setCustom(ce);
			s.setDate(date);
			s.setTotalprice(totalprice);
			s.setBuyer(buyer);
			
			//���� ���
			if("add".equals(act)) {
				//������ӵķ���
				sm.insert(s);
			}else if("mdy".equals(act)) {
				//�����޸ĵķ���
				sm.updateStock(s);
			}
			
			//ת������ѯ���Բɹ���Ϣ�ĵ�ַ
			return "redirect:/StockList";
		}
	}
}

