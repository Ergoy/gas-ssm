package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Custom;
import com.star.entity.Sell;
import com.star.entity.ToCustom;
import com.star.mapper.CustomMapper;
import com.star.mapper.SellMapper;
import com.star.mapper.ToCustomMapper;



@Controller
public class ToCustomController {
	@Autowired
	private ToCustomMapper tum;
	@Autowired
	private CustomMapper cm;
	@Autowired
	private SellMapper sm;
	
	@RequestMapping("/ToCustomList")
	public String findAllToCustom(HttpServletRequest request) {
		List<ToCustom> listtc = tum.findAll();
		request.setAttribute("list", listtc);
		return "/toCustomList";
	}

	@RequestMapping("/ToCustomModify")
	public String ToCustomModify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		String act = request.getParameter("act");
		
		// ���Գ�ʼֵ
		/* System.out.println("��ʼid:" + id);
		System.out.println("��ʼact:" + act);
		System.out.println("��ʼflag:" + flag);*/
		List<Custom> list = cm.selectCustomByType(2);
		// ����
		request.setAttribute("customs", list);		
		List<Sell> list1 = sm.findAll();
		// ����
		request.setAttribute("customss", list1);
		// ɾ��	
		if (flag != null) {
			//���ø���idɾ���ķ���
			tum.deleteCustom(id);
			//ת��
			return "redirect:/ToCustomList";
		}
		//�ж�(�ǵ���ı��滹������)
		if (act == null) {
					
			if (id == null) {
				// ���
			} else {
				// �޸�
				ToCustom p = tum.findById(id);
				request.setAttribute("custom", p);
				//ת�����༭����
			}
			return "toCustomForm";
		}else {
			
			//��ȡ����ʱ���ݵ�����
			String cbid = request.getParameter("cbid");
			String cid = request.getParameter("cid");
			String sid = request.getParameter("sid");
			String date = request.getParameter("date");
			double totalprice = Double.parseDouble(request.getParameter("totalprice"));
			// ʵ����
			ToCustom p = new ToCustom();
			p.setCbid(cbid);
			Custom ce = new Custom();
			ce.setCid(cid);
			p.setCustom(ce);
			Sell s = new Sell();
			s.setSid(sid);
			p.setSell(s);
			p.setDate(date);
			p.setTotalprice(totalprice);
			
			//���� ���
			if ("add".equals(act)) {
				//������ӵķ���
				tum.insert(p);
			} else if ("mdy".equals(act)) {
				//�����޸ĵķ���
				tum.updateCustom(p);
			}
			
			//ת������ѯ���������˻��ĵ�ַ
			return "redirect:/ToCustomList";
		}
		
	}
}
