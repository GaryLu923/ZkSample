# ZkSample
zk Web Application   


CRUD Sample Integration with :
------------------------------   
1.	ZK CORE
2.	Spring CORE
3.	Spring Security
4.	Hibernate lib
***


Hibernate-hsqldb persistence setting :
--------------------------------------  

It provide you 4 mode to use

1. **In-process Mode:**<br/>  	
To store your database in physical disk path.It won't lost your data,when server is down.<br/>   
    *property name="hibernate.connection.url" value="jdbc:hsqldb:file:C:/data/sample"*<br/>

2. **Memory-Only Mode:**<br/>
To store your database in memory.<br/>   
    *property name="hibernate.connection.url" value="jdbc:hsqldb:mem:data/store"*<br/>    
3. **Server Mode:**<br/>
To store your database in server,like MySQL,MSSQL,PostgreSQL...<br/>       
    *property name="hibernate.connection.url" value="jdbc:hsqldb://localhost:port/dbname"*<br/>  

4. **WebServer Mode:**<br/>
To access your database with HTTP Server.<br/>   
    *property name="hibernate.connection.url" value="jdbc:hsqldb:http://localhost:port/dbname"*<br/>


Reference from :
--------------------------------------  

## Records
Item|link
-------------|------- 
zk           |[zk](https://www.zkoss.org/)
hsqldb       |[hsqldb](http://hsqldb.org/index.html)
hsqldb_basic |[hsqldbtutorial](http://java.openyu.org/2014/03/hsqldb1-database.html)
hsqldb_gui   |[hsqldb gui](http://java.openyu.org/2014/03/hsqldb3-guitable.html)
