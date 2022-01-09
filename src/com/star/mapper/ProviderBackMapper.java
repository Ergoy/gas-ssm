package com.star.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.star.entity.Provider;
import com.star.entity.ProviderBack;

@Repository("providerBackMapper")
public interface ProviderBackMapper {
	public List<ProviderBack> fandAll(@Param("pbdid")String pbdid);
	public ProviderBack findById(@Param("pbdid")String pbdid);
	public int updateProvider_back(ProviderBack pb);
	public int insert (ProviderBack pb);
	public int deleteProvider_back (@Param("pbdid")String pbdid);

	
}


