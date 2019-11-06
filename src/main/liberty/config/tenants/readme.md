mount tenant configurations in this folder, and put tenant configuration file like below


e.g. tenant1.json

```json
{
	"id": "tenant1",
	"name": "Tenant 1",
	
	"db2-vm": {
		"updated": "2019-06-28T00:00:00.000",
		"host":"<VM DB Host>",
		"port": "<VM DB Port>",
		"database": "<Database Name>",
		"schema": "<Databae Schema>",
		"user": "<Username>",
		"password": "<Passw0rd>",
		"sslEnabled": true, //if enabled ssl
		"sslCert": "<base64 encoded x.509 certificate>",
		"maxPoolSize": 10, //connection pool size
		"minPoolSize": 10  //connection pool size
	}
}
```

