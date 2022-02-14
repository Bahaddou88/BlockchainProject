const express = require('express');
const app = require('express')();
const http = require('http').createServer(app);
const io = require('socket.io')(http);
const moment = require('moment')
const SerialPort = require('serialport');

app.use(express.static('client'));
const Readline = SerialPort.parsers.Readline;
const port = new SerialPort('COM5'); // Port your Arduino is connected to
const parser = new Readline();
port.pipe(parser);

port.on("open", function () {
  console.log('COM5 Port opened'); 
  parser.on('data', function(data) {
    const sensorData = {
      dataset: data,
      time: moment().unix() // Unix timestamps
    }
    if(sensorData.dataset.includes("Temperature")) {
      sensorData.dataset = sensorData.dataset.replace("Temperature: ", "");
      io.emit('temperature-data', sensorData)
    } else if (sensorData.dataset.includes("Humidity")) {
      sensorData.dataset = sensorData.dataset.replace("Humidity: ", "");
      io.emit ('humidity-data', sensorData)
    }
  });
});

io.on('connection', (socket) => {
  console.log('a user connected');
  socket.on('disconnect', () => {
    console.log('user disconnected');
  });
});

http.listen(3000, () => {
  console.log('listening on *:3000');
});




 
            
 
var brightness = 0;
 
io.sockets.on('connection', function (socket) {
        socket.on('led', function (data) {
                brightness = data.value;
               
                var buf = new Buffer(1);
                buf.writeUInt8(brightness, 0);
                port.write(buf);
                console.log(buf);
                if(brightness>50){
                io.sockets.emit('led', {value: brightness});  
              } 
                console.log('led', {value: brightness})        
        });
       
        socket.emit('led', {value: brightness});
      
});
 
console.log("Web Server Started go to 'http://localhost:8080' in your Browser.");