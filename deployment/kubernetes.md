# Crear un cluster local
## Kind
````shell
kind create cluster --name my-cluster
````
## Minikube
````shell
minikube start
````

## Port Forwarding
````shell
kubectl port-forward service/my-service 8080:80
````