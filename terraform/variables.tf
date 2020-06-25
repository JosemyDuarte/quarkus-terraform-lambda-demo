variable "account_id" {
}

variable "region" {
}

variable "lambda_payload_filename" {
  default = "../target/function.zip"
}

variable "lambda_function_handler" {
  default = "io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler"
}

variable "lambda_runtime" {
  default = "java11"
}

variable "api_path" {
  default = "helloworld"
}

variable "hello_world_http_method" {
  default = "POST"
}

variable "api_env_stage_name" {
  default = "beta"
}
