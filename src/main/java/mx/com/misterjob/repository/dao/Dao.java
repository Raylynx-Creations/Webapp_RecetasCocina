package mx.com.misterjob.repository.dao;

import java.io.Serializable;

public interface Dao<T, PK> extends Serializable{
	
		PK create(final T newInstance); // insert into.......

		T read(final PK id); // select * from .......

		void update(final T transientObject); // update tabla set ...........

		void delete(final PK persistentObjectId); // delete from .......

		void saveOrUpdate(final T transientObject);
	   
		void updateWithNoFlush(final T transientObject);
		void flush();
}