package com.reetu.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reetu.beans.Mobile;

@Repository
public class Mobilerepo {
	
                           @Autowired
                           JdbcTemplate jdbcTemplate;
                           
                     //to add mobile   
                     public String addmoblie(Mobile m, InputStream image1){
                    	 try {
                    		 String query = "insert into info values(?,?,?)";
                        	 jdbcTemplate.update(query, new Object[] {m.getMname(), m.getMprice(), image1});
                        	 return "success";
						} catch (Exception e) {
							return "failed";
						}
                     }
                     
                  //to delete moblie 
                  public String deletemobile(String name) {
                	  try {
                		      String query = "delete from info where mname=?";
                		      int x = jdbcTemplate.update(query, new Object[] {name});
						if(x!=0)
							  return "Success";
						else
							 return "failed";
					} catch (Exception e) {
						e.printStackTrace();
						return "failed";
					}
                  }
                 // toview all mobile
                 public List<Mobile> getallmobile(){
                	 
                	  class MobileMappper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Mobile m = new Mobile();
							m.setMname(rs.getString("mname"));
							m.setMprice(rs.getInt("mprice"));
	                        return m;
						}
                		 
                	 }
                	 try {
                		   final String query = "select * from info";
                    	   List<Mobile> m = jdbcTemplate.query(query, new MobileMappper());
                    	  return m;
						
					} catch (Exception e) {
						return null;
					}
                	 
            }
            //get image1
            public byte [] getimage(String mname) {
            	
            	class MobileMapper implements RowMapper{

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
						
						return rs.getBytes("image1");
					}
            		
            	}
            	try {
					   final String query = "select image1 from info where mname=?";
					   byte [] b = (byte []) jdbcTemplate.queryForObject(query, new MobileMapper(), new Object[] {mname});
					   return b;
				} catch (EmptyResultDataAccessException e) {
					e.printStackTrace();
					return null;
				}
            }

          //get all mobile name
            public List<String> getallmobilename(){
            	
            class MobileMapper implements RowMapper{

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						return rs.getString("mname");
					}
            		
            	}
            	try {
            		  final String query = "select * from info";
            		  List<String> data = jdbcTemplate.query(query, new MobileMapper());
            		  return data;
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
            }
           //to update mobile
            public String updatemobile(String name, Mobile m) {
            	String query = "update info set mname=?, mprice=? where mname=?";
            	int x = jdbcTemplate.update(query, new Object[] {m.getMname(), m.getMprice(), name});
            	if(x!=0)
            		return "success";
            	else
            		return "failed";
            	
            	
            }
          
        }
