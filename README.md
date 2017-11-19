# ZkSample
zk Web Application   

CRUD Sample Integration with :
1.ZK CORE
2.Spring CORE
3.Spring Security
4.Hibernate lib
***
Hibernate-hsqldb persistence setting :

It provide you 4 mode to use

1.### In-process Mode
To store your database in physical disk path.It won't lost your data,when server is down.
		<property name="hibernate.connection.url" value="jdbc:hsqldb:file:C:/data/sample" />

2.### Memory-Only Mode
To store your database in memory.
		<property name="hibernate.connection.url" value="jdbc:hsqldb:mem:data/store" />
3.### Server Mode
To store your database in server,like MySQL,MSSQL,PostgreSQL...
		<property name="hibernate.connection.url" value="jdbc:hsqldb://localhost:port/dbname" />

4.### WebServer Mode
To access your database with HTTP Server. 
		<property name="hibernate.connection.url" value="jdbc:hsqldb:http://localhost:port/dbname" />


Reference from : [zk](https://www.zkoss.org/),
[hsqldb](http://hsqldb.org/index.html),
[hsqldb_tutorial](http://java.openyu.org/2014/03/hsqldb1-database.html)
[hsqldb_gui_tutorial](http://java.openyu.org/2014/03/hsqldb3-guitable.html).