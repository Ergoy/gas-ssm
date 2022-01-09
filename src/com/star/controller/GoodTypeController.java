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
		//��ȡ����ʱ�Ĳ���
		String act = request.getParameter("act");
		//�ж�(�ǵ���ı��滹��������(act�Ǳ���))
		if (act == null) {
					
			//�ж�(��ʱ���޸�ɾ�����Ǳ༭)
			if ("d".equals(flag)) {
				//ɾ��(���ø���idɾ���ķ���)
				gtm.deleteGoodsType(id);
				return "redirect:/GoodsTypeList";
			} else {
				if (id == null) {
					//���(ת������ӽ���)
				} else {
					//�޸�
					GoodsType gt = gtm.getGoodsTypeById(id);
					//��ȡ��id��ӵ�type
					request.setAttribute("type", gt);
				}
				//ת�����༭����
				return "goodsTypeForm";
			}

		}	else {
			//��ȡ����ʱ���ݵ�����
			String tid = request.getParameter("tid");
			String name = request.getParameter("name");
			//�������� ����ֵ
			GoodsType gt=new GoodsType();
			gt.setTid(tid);
			gt.setName(name);
			//���� ���
			if ("add".equals(act)) {
				//������ӵķ���
				int i = gtm.addGoodsType(gt);
						
			} else if ("mdy".equals(act)) {
				//����ʱ���޸�
				//�����޸ĵķ���
				int i = gtm.updateGoodsType(gt);
				//ת������ѯ������Ʒ���ĵ�ַ
			}
			//�������²�ѯ��������servlet������в���ֱ����ת��������GoodsTypeList ���²�ѯ��
			return "redirect:/GoodsTypeList";
		}
	}
}



