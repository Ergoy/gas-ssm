package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.ToCustom;
import com.star.entity.ToCustomBack;
import com.star.mapper.GoodsMapper;
import com.star.mapper.ToCustomBackMapper;
import com.star.mapper.ToCustomMapper;



@Controller
public class ToCustomBackController {
	@Autowired
	private ToCustomBackMapper tcbm;	
	@Autowired
	private ToCustomMapper tcm;	
	@Autowired
	private GoodsMapper gm;	
	
	@RequestMapping("/ToCustomBackList")
	public String findAllTC(HttpServletRequest request) {
		//��ȡ��id
		String id=request.getParameter("id");
		List<ToCustomBack> pb=tcbm.fandAll(id);
		//����(�Ѽ��ϴ洢��request)
		request.setAttribute("list", pb);
		//ת��(��ת��toCustomBackList.jsp����)
		return "toCustomBackList";		
	}
	@RequestMapping("/ToCustomBackModify")
	public String ToCustomeModify(HttpServletRequest request) {
		//��ȡ����ֵ
		String id = request.getParameter("id");
		String flag = request.getParameter("flag");
		//��ȡ���²�ѯ��id
		String cbid = request.getParameter("cbid");
		//��ȡ�ж����name��ֵ
		String act = request.getParameter("act");
		List<ToCustom> list = tcm.findAll();
		request.setAttribute("backs", list);
		//�ڶ���	
		List<Goods> lis = gm.findAll();
		request.setAttribute("good", lis);
		// ɾ��
		if (flag != null) {
			//���ø���idɾ���ķ���
			tcbm.deleteCustom_back(id);
			List<ToCustomBack> pb = tcbm.fandAll(cbid);
			request.setAttribute("list", pb);
			// ת��
			return "toCustomBackList";
		}
		//�ж�(�ǵ���ı��滹������)
		if (act == null) {
			if (id == null) {
				// ����
			} else {
				// �޸�
				ToCustomBack pb = tcbm.findById(id);
				request.setAttribute("back", pb);
			}
			//ת�����༭����
			return "toCustomBackForm";
		}else {	
			//��ȡ����ʱ���ݵ�����
			String cbdid = request.getParameter("cbdid");
			String gid = request.getParameter("gid");
			double price = Double.parseDouble(request.getParameter("price"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			ToCustomBack pb = new ToCustomBack();
			pb.setCbdid(cbdid);
			ToCustom p = new ToCustom();
			p.setCbid(cbid);
			pb.setCust(p);
			Goods g = new Goods();
			g.setGid(gid);
			pb.setGoods(g);
			pb.setPrice(price);
			pb.setAmount(amount);
			
			//���� ���
			if ("add".equals(act)) {
				//������ӵķ���
				tcbm.insert(pb);
			} else if ("mdy".equals(act)) {
				//�����޸ĵķ���
				tcbm.updateCustom_back(pb);
			}
			
			List<ToCustomBack> pbs = tcbm.fandAll(cbid);
			request.setAttribute("list", pbs);
			//ת������ѯ��ַ
			return "toCustomBackList";
		}		
	}
}
