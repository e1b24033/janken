package oit.is.z3420.kaizi.janken.model;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT id, user1, user2, user1Hand, isActive FROM matchinfo WHERE isActive = TRUE;")
  ArrayList<MatchInfo> selectActiveMatchInfo();

  @Insert("INSERT INTO matchinfo (user1, user2, user1Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{isActive});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchInfo);

}
