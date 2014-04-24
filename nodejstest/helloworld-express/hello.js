var express = require('express');
var app = express();

app.get('/', function process(req, res) {
  res.send('Hello World!');
}).listen(8888);

console.log("server running");
