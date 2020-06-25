## PoC of Quarkus with AWS Lambdas configure through Terraform

### Requirements

1. An [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html) already configure in your machine
2. [Terraform installed](https://learn.hashicorp.com/terraform/getting-started/install.html)
3. JDK 11+ & Maven 3+
4. Curl/Postman

## How to try it?

First create a package: `mvn clean package`

After that, a `zip` with our code should be in `target` folder. Let's execute `terraform apply` to upload our code to AWS.

DONE. Now you can try your lambda just executing the last line of the terraform output, it should be something like this: 
`curl -H 'Content-Type: application/json' -X POST -d '{"name": "Josemy", "greeting":"Hello"}' https://[ACCOUNT_ID].execute-api.[REGION].amazonaws.com/beta/helloworld`
