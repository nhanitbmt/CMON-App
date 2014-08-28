package vn.dtt.cmon.dao.qlhc.service.persistence;


import java.util.List;

import vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;
import vn.dtt.cmon.dao.qlhc.model.impl.CoQuanHanhChinhSuNghiepImpl;


import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class CoQuanHanhChinhSuNghiepFinderImpl   extends BasePersistenceImpl<CoQuanHanhChinhSuNghiep> implements CoQuanHanhChinhSuNghiepFinder {
	
	public java.util.List<CoQuanHanhChinhSuNghiep> getDonViHanhChinhCha(){
		
		java.util.List<CoQuanHanhChinhSuNghiep> result = null;
		
        Session session = null;
        
        try {  
            
        	session = openSession();  
            // Here ends the basic set up;   
  
            //now we build the query. Note that we use the name of the tables from the database!  
            String base = "select * from cmon_coquanhanhchinhsunghiep " ;  
            StringBuffer sqlBuilder = new StringBuffer(base);  
            // List<String> criteria = new ArrayList<String>();  
           
            // sqlBuilder.append("where id in (select distinct chaid  from cmon_coquanhanhchinhsunghiep)");
            sqlBuilder.append("where daxoa = 0 ");
            sqlBuilder.append("and chaid is null");
                
            String sql = sqlBuilder.toString();  
            // Now that we have built the query, we can do all the usual stuff.  
            SQLQuery q = session.createSQLQuery(sql);  
            q.setCacheable(false);  
            q.addEntity("CoQuanHanhChinhSuNghiep", CoQuanHanhChinhSuNghiepImpl.class);  
  
            QueryPos qPos = QueryPos.getInstance(q);  
            //execute the query and return a list from the db  
            result= (List<CoQuanHanhChinhSuNghiep>) QueryUtil.list(q, getDialect(), 0, 100);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            //must have this to close the hibernate session..  
            // if you fail to do this.. you will have a lot of open sessions�   
            closeSession(session);  
        }
        return result;
		
	}

}
