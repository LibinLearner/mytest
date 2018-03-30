package cn.itcast.core.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import cn.itcast.core.pojo.User;

public class SolrDao {

	public List<User> findAllBySolr(){
		// 获取与solr服务端的连接
		String baseURL = "http://localhost:8080/solr";
		SolrServer solrServer = new HttpSolrServer(baseURL);
		// 查询
		SolrQuery params = new SolrQuery();
		params.set("q", "*:*");
		// 执行查询
		QueryResponse response = null;
		try {
			response = solrServer.query(params);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		SolrDocumentList docs = response.getResults();// 得到结果集
		List<User> userList = new ArrayList<>();
		//数据转移
		for (SolrDocument doc : docs) {
			User user = new User();
			
			user.setId((Integer) doc.get("id"));
			user.setName((String) doc.get("name"));
			user.setBirthday((Date) doc.get("birthday"));
			userList.add(user);
		}
		return userList;
	}

}
