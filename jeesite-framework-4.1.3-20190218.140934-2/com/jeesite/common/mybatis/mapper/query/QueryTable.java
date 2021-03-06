package com.jeesite.common.mybatis.mapper.query;	
	
import com.jeesite.common.entity.BaseEntity;	
import com.jeesite.common.j2cache.autoconfigure.J2CacheAutoConfiguration;	
import com.jeesite.common.mybatis.annotation.JoinTable;	
import com.jeesite.common.mybatis.annotation.Table;	
import com.jeesite.common.mybatis.mapper.MapperHelper;	
import java.io.Serializable;	
import org.hyperic.sigar.ProcState;	
	
public class QueryTable implements Serializable {	
   private static final long serialVersionUID = 1L;	
   private BaseEntity entity;	
	
   public QueryTable(BaseEntity var1) {	
      this.entity = var1;	
   }	
	
   public String toSql() {	
      StringBuilder a = new StringBuilder();	
      Table a = MapperHelper.getTable(this.entity);	
      a.append(MapperHelper.getTableName(a, this.entity) + " " + a.alias());	
      JoinTable[] var4 = a.joinTable();	
      int var5 = var4.length;	
	
      int var6;	
      for(int var10000 = var6 = 0; var10000 < var5; var10000 = var6) {	
         JoinTable a;	
         Table a = MapperHelper.getTable((a = var4[var6]).entity());	
         a.append((new StringBuilder()).insert(0, " ").append(a.type().value()).append(" ").toString());	
         a.append((new StringBuilder()).insert(0, MapperHelper.getTableName(a, this.entity)).append(" ").append(a.alias()).toString());	
         StringBuilder var10003 = (new StringBuilder()).insert(0, " ON ");	
         String var10004 = a.on();	
         ++var6;	
         a.append(var10003.append(var10004).toString());	
      }	
	
      a.append(MapperHelper.getSqlMapValue(this.entity, a.extFromKeys()));	
      return a.toString();	
   }	
}	
