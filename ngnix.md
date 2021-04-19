# ngnix

* 反向代理

![image-20210413172627485](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413172627485.png)

![image-20210413172746778](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413172746778.png)

[root@hadoop102 ~]# systemctl enable nginx
Created symlink from /etc/systemd/system/multi-user.target.wants/nginx.service to /usr/lib/systemd/system/nginx.service.

![image-20210413183952573](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210413183952573.png)

	server {
	listen 80;
	server_name  192.168.28.128;
	location / {
	    proxy_pass http://192.168.28.128:9004;
		root   /usr/share/nginx/html;
	    index  index.html index.htm;
	}
	
	#error_page  404              /404.html;
	# redirect server error pages to the static page /50x.html
	error_page   500 502 503 504  /50x.html;
	location = /50x.html {
	    root   /usr/share/nginx/html;
	}
	
	}
192.168.28.128 为服务器ip地址

 #gzip  on;
	upstream myserver{
	server 192.168.28.128:9004 weight=2;
	server 192.168.28.128:9003;
	}

	server {
	listen 80;
	server_name  192.168.28.128;
	location / {
	    proxy_pass http://myserver;
		root   /usr/share/nginx/html;
	    index  index.html index.htm;
	}

权重用于后端服务器性能不均的情况



负载均衡 ip_hash 解决session问题

fair方式分配 响应时间越短优先分配

 ![image-20210416150543459](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210416150543459.png)

nginx高可用 主从

![image-20210416151746117](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210416151746117.png)

nohup java -jar testDemo-spring-boot-9004.jar >/dev/null 2>&1

nohup java -jar testDemo-spring-boot9003.jar >/dev/null 2>&1

![image-20210416162502372](C:\Users\sun\AppData\Roaming\Typora\typora-user-images\image-20210416162502372.png)

cat /etc/sysconfig/network-scripts/ifcfg-ens33

systemctl restart nginx

systemctl restart keepalived.service