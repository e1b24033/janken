package oit.is.z3420.kaizi.janken.model;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MatchInfoMapper {

  @Select("SELECT id, user1, user2, user1Hand, isActive FROM matchinfo WHERE isActive = TRUE;")
  ArrayList<MatchInfo> selectActiveMatchInfo();

  @Select("SELECT id, user1, user2, user1Hand, isActive FROM matchinfo WHERE user1 = #{user1} AND user2 = #{user2} AND isActive = TRUE;")
  MatchInfo selectByUsers(@Param("user1") int user1, @Param("user2") int user2);

  @Insert("INSERT INTO matchinfo (user1, user2, user1Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{isActive});")

  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatchInfo(MatchInfo matchInfo);

  @Update("UPDATE matchinfo SET isActive = FALSE WHERE id = #{id};")
  void updateIsActiveToFalse(int id);
}
