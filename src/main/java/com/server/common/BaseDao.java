		package com.server.common;
		
		import java.util.List;
		
		public interface BaseDao<T> {
			
			T insert(T t);
			
			void update(T t);
			
			void delete(int id);
			
			List<T> selectAll(T t);
			
			T getById(int id);
			
		}
