package com.piggsoft.pigg.dao;

import com.piggsoft.pigg.model.GrowthHistory;
import com.piggsoft.pigg.model.GrowthHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrowthHistoryMapper {
    int countByExample(GrowthHistoryExample example);

    int deleteByExample(GrowthHistoryExample example);

    int deleteByPrimaryKey(Integer historyId);

    int insert(GrowthHistory record);

    int insertSelective(GrowthHistory record);

    List<GrowthHistory> selectByExample(GrowthHistoryExample example);

    GrowthHistory selectByPrimaryKey(Integer historyId);

    int updateByExampleSelective(@Param("record") GrowthHistory record, @Param("example") GrowthHistoryExample example);

    int updateByExample(@Param("record") GrowthHistory record, @Param("example") GrowthHistoryExample example);

    int updateByPrimaryKeySelective(GrowthHistory record);

    int updateByPrimaryKey(GrowthHistory record);
}