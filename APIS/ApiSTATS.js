const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-2'});
const docClient2 = new AWS.DynamoDB.DocumentClient({region: 'us-east-2'});
exports.handler = async(e, cta, callback)  => {
  var result;
   var cantidadHumano= 0;
   var cantidadMutante= 0;

  
  await obtenerMutantes().then(data => {
    console.log(data.Count);
    cantidadMutante = data.Count;
  }).catch((err) =>{
    
    console.error(err);
    
  })
  
    
  await obtenerHumanos().then(data => {
    console.log(data.Count);
    cantidadHumano= data.Count;
  }).catch((err) =>{
    
    console.error(err);
    
  })
  

   
  result = {
    count_human_dna: cantidadHumano,
    count_mutant_dna: cantidadMutante,
    ratio: cantidadMutante / cantidadHumano
  };

return result;

   
  
};

function obtenerMutantes(){
    const paramsMutant = {
    TableName : 'mutante'
  }; 
  return docClient.scan(paramsMutant).promise();
}

function obtenerHumanos(){
    const paramsHuman = {
    TableName : 'humano'
  }; 
  return docClient2.scan(paramsHuman).promise();
}


