## PoC of Quarkus with AWS Lambdas configured through Terraform

### Requirements

1. An [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-quickstart.html) already configure in your machine
2. [Terraform installed](https://learn.hashicorp.com/terraform/getting-started/install.html)
3. JDK 11+ & Maven 3+
4. Curl/Postman

## How to try it?

Just execute:

* `cd terraform && terraform init && cd ..` (First time only)
* `sh build_and_deploy.sh`

DONE. Now you can try your lambda just executing the last line of the terraform output, it should be something like this: 
`curl -H 'Content-Type: application/json' -X POST -d '{"userId": "SomeUserId"}' https://[ACCOUNT_ID].execute-api.[REGION].amazonaws.com/beta/helloworld`

## Disclaimer

Please note: I'm not responsible for any costs incurred within your AWS account :-)

Same code that the one in [plain java](https://github.com/JosemyDuarte/poc-plain-java-lambda-terraform). I will try a benchmark against that repo.