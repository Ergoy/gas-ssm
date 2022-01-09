package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Sell;
import com.star.mapper.CustomMapper;
import com.star.mapper.SellMapper;



@Controller
public class SellController {
	@Autowired
	private SellMapper sm;
	@Autowired
	private CustomMapper cm;
	
	@RequestMapping("/SellList")
	public String findAllSell(HttpServletRequest request) {
		List<Sell> listsl = sm.findAll();
		request.setAttribute("list", listsl);
		return "/sellList";
	}
	@RequestMapping("/SellModify")
	public String SellModify(HttpServletRequest request) {
		// ��ȡ����ֵ
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		// ��ȡ�ж����name��ֵ
		String act = request.getParameter("act");
		
		// ���Գ�ʼֵ
		/* System.out.println("��ʼact:" + act);
		System.out.println("��ʼId:" + id);
		System.out.println("flag:" + flag);  */
		
		// ��ѯ������Ϣ

		List<Custom> list = cm.selectCustomByType(1);
		// ����
		request.setAttribute("provider", list);
		// ɾ��
		if (flag != null) {
			//���ø���idɾ���ķ���
			sm.deleteSell(id);
			//ת��
			return "redirect:/SellList";
		}
		
		//�ж�(�ǵ���ı��滹������)
		if (act == null) {
			
			if (id == null) {
				// ���
			} else {
				// �޸�
				Sell s = sm.findById(id);
				request.setAttribute("sell", s);
			}
			//ת�����༭����
			return "sellForm";
		} else {
			
			// ��ȡ����ʱ���ݵ�����
			String sid = request.getParameter("sid");
			String cid = request.getParameter("cid");
			String date = request.getParameter("date");
			double totalprice = Double.parseDouble(request.getParameter("totalprice"));
			String buyer = request.getParameter("buyer");
			// ʵ����Stock
			Sell s = new Sell();
			s.setSid(sid);
			// ʵ����custom
			Custom ce = new Custom();
			ce.setCid(cid);
			s.setCustom(ce);
			s.setDate(date);
			s.setTotalprice(totalprice);
			s.setBuyer(buyer);
			
			//���� ���
			if ("add".equals(act)) {
				//������ӵķ���
				sm.insert(s);

			} else if ("mdy".equals(act)) {
				//�����޸ĵķ���
				sm.updateSell(s);
			}
			
			//ת������ѯ����������Ϣ�ĵ�ַ
			return "redirect:/SellList";
		}		
	}
}

