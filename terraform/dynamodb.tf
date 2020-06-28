resource "aws_dynamodb_table_item" "demo-dynamodb-item" {
  table_name = aws_dynamodb_table.demo-dynamodb-table.name
  hash_key = aws_dynamodb_table.demo-dynamodb-table.hash_key

  item = <<ITEM
{
  "userId": {"S": "SomeUserId"},
  "gameTitle": {"S": "Battlefield"},
  "topScore": {"N": "9"}
}
ITEM
}

resource "aws_dynamodb_table" "demo-dynamodb-table" {
  name = "GameScores"
  billing_mode = "PROVISIONED"
  read_capacity = 10
  write_capacity = 10
  hash_key = "userId"

  attribute {
    name = "userId"
    type = "S"
  }

  ttl {
    attribute_name = "TimeToExist"
    enabled = false
  }

  tags = {
    Name = "dynamodb-table-1"
    Environment = "test"
  }
}