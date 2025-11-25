# Docker
## 1.
```Dockerfile
FROM payara/server-full:6.2023.12

# Copy PostgreSQL driver to the correct lib directory
COPY target/postgresql.jar /opt/payara/appserver/glassfish/domains/domain1/lib/

# Copy WAR to autodeploy directory
COPY target/cargo-tracker.war /opt/payara/appserver/glassfish/domains/domain1/autodeploy/

EXPOSE 8080 4848

# Start domain in verbose mode
CMD ["asadmin", "start-domain", "-v", "domain1"]
```
## 2.
- Si vous parlez de l'image qu'on a créé alors son nom est **cargo-tracker** et sa version (tag) is "latest"
- Si vous parlez de l'image de base de notre projet alors son nom est **server-full** du repo **payara** et sa version est 6.2023.12
## 3.
pour lancer le Dockerfile il faut avoir Docker Desktop .
```bash
docker build -t cargo-tracker:latest . 
docker run -p 9009:8080 -p 4848:4848 --name cargo-tracker-app cargo-tracker:latest
```
et pour le Dockerfile lance cette commande:
```Dockerfile
CMD ["asadmin", "start-domain", "-v", "domain1"]
```
# Kubernetes
## 1.
```sh
kubectl get pods
```
```sh
NAME                                       READY   STATUS    RESTARTS   AGE
cargo-tracker-deployment-c67b8f8d5-86b66   1/1     Running   0          6m33s
cargo-tracker-deployment-c67b8f8d5-l7fdp   1/1     Running   0          5m37s
```
so here the number of pods is **2**

## 2.
```sh
kubectl get all
```

```sh
NAME                                           READY   STATUS    RESTARTS   AGE
pod/cargo-tracker-deployment-c67b8f8d5-86b66   1/1     Running   0          8m35s
pod/cargo-tracker-deployment-c67b8f8d5-l7fdp   1/1     Running   0          7m39s

NAME                            TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)   AGE
service/cargo-tracker-service   ClusterIP   10.106.36.152   <none>        80/TCP    8m53s
service/kubernetes              ClusterIP   10.96.0.1       <none>        443/TCP   10m

NAME                                       READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/cargo-tracker-deployment   2/2     2            2           8m58s

NAME                                                  DESIRED   CURRENT   READY   AGE
replicaset.apps/cargo-tracker-deployment-66568bd7dd   0         0         0       8m58s
replicaset.apps/cargo-tracker-deployment-c67b8f8d5    2         2         2       8m35s
```

## 3.
```sh 
http://127.0.0.1:50726/  # payara
http://127.0.0.1:50726/cargo-tracker/ # main page
http://127.0.0.1:50726/cargo-tracker/admin/dashboard.xhtml # admin dashboard 
```

