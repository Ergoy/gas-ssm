package com.star.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.Goods;
import com.star.entity.Stock;
import com.star.entity.StockDetail;
import com.star.mapper.GoodsMapper;
import com.star.mapper.StockDetailMapper;
import com.star.mapper.StockMapper;


@Controller
public class StockDetailController {
	@Autowired
	private StockDetailMapper sdm;
	@Autowired
	private StockMapper sm;	
	@Autowired
	private GoodsMapper gm;	
	
	@RequestMapping("/StockDetailList")
	public String findAllStockD(HttpServletRequest request) {
		//��ȡ��id
		String id= request.getParameter("id");
		List<StockDetail> sd=sdm.findAll(id);
		request.setAttribute("list", sd);
		//ת��(��ת��stockDetailList.jsp����)
		return "stockDetailList";
	}
	@RequestMapping("/StockDetailModify")
	public String StockDModify(HttpServletRequest request) {
		String id=request.getParameter("id");
		String flag=request.getParameter("flag");
		//��ȡ���²�ѯ��id
		String ids=request.getParameter("ids");
		//��ȡ�ж����name��ֵ
		String act=request.getParameter("act");	
		/* System.out.println("��ʼids:"+ids);
		System.out.println("��ʼact:"+act);
		System.out.println("Modify��ʼId:"+id);*/
		
		//��ȡ�ɹ�id
		List<Stock> list=sm.findAll();
		//��ȡ��Ʒ
		List<Goods> list2=gm.findAll();	
		request.setAttribute("stock", list);
		request.setAttribute("goods", list2);
		//ɾ��
		if(flag!=null) {
			//���ø���idɾ���ķ���
			sdm.deleteStockDetail(id);
			//���²�ѯ
			List<StockDetail> lsd=sdm.findAll(ids);
			request.setAttribute("list", lsd);
			// ת��
			return "stockDetailList";
		}
		//�ж�(�ǵ���ı��滹������)
		if(act==null) {			
			if(id==null) {
				//���
			}else {
				//�޸�
				StockDetail sd=sdm.findById(id);
				request.setAttribute("detail", sd);	
			}
			//ת�����༭����
			return "stockDetailForm";
		}else {
			
			//��ȡ����ʱ���ݵ�����
			String sdid=request.getParameter("sdid");
			String sid=request.getParameter("sid");
			String gid=request.getParameter("gid");
			int amount=Integer.parseInt(request.getParameter("amount"));
			double price=Double.parseDouble(request.getParameter("price"));
			//ʵ����StockDetail
			StockDetail sd=new StockDetail();
			sd.setSdid(sdid);
			//ʵ����Stock
			Stock s=new Stock();
			s.setSid(sid);
			sd.setStock(s);
			//ʵ����Goods
			Goods g=new Goods();
			g.setGid(gid);
			sd.setGoods(g);
			sd.setAmount(amount);
			sd.setPrice(price);
			
			//���� ���
			if("add".equals(act)) {
				//������ӵķ���
				sdm.insert(sd);			
			}else if("mdy".equals(act)) {
				//�����޸ĵķ���
				sdm.updateStockDetail(sd);				
			}
			
			//���²�ѯ
			List<StockDetail> sds=sdm.findAll(sid);
			request.setAttribute("list", sds);
			//ת������ѯ�ĵ�ַ
			return "stockDetailList";
		}		
	}
}