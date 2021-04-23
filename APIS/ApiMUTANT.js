
const AWS = require('aws-sdk');
const docClient = new AWS.DynamoDB.DocumentClient({region: 'us-east-2'});
exports.handler = (event, cta, callback)  => {
    

    adn = event.dna;
    
    //Se valida que la secuencia suministrada sea NxN
    if(!validaADN(adn)){
        callback(null, 'La Secuencia Ingresada no es NxN');
        
    }
    
    // TODO implement
    if(isMutant(adn)){
        //Insertar en la tabla
          var params = {
    Item: {
        secuencia: JSON.stringify(adn)
    },
    TableName: 'mutante'
  };  
  docClient.put(params, function(err, data){
   
                  if(err){
                      callback(err,null);
                  }else{
                      callback(err, "Es Mutante");
                  }     
  }); 

    }else{
                    //Insertar en la tabla
                      var params = {
                Item: {
                    secuencia: JSON.stringify(adn)
                    
                },
                TableName: 'humano'
              };  
              docClient.put(params, function(err, data){
                  if(err){
                      callback(err,null);
                  }else{
                      callback(null, "Es humano");
                  }      
              }); 
        
        
    }
    
};


 function isMutant(dna) {
		
		 total = 0;
		
		total = total + validarFila(dna);
		total = total + validarColumnas(dna);
		total = total + validarOblicuas(dna);
		
		if(total > 1) {
			
			return true;
		}else {
			return false;
		}
		
	}

function validarFila(dna) {
		 contador_secuencias = 0;
		
		for(var j = 0; j < dna.length; j++ ) {
			
			if(encuentraSecuencia(dna[j])) {
				contador_secuencias++;
			}
		
		}
		
		
		return contador_secuencias;
	}



function validarColumnas(dna){
     tamanioFila = dna.length;
	 contador_secuencias = 0;
		for(var i = 0; i<tamanioFila; i++) {
			 cadenaTemporal = "";
			for(var j = 0; j < dna.length; j++ ){
				cadenaTemporal = cadenaTemporal+dna[j][i];
			}
			
			if(encuentraSecuencia(cadenaTemporal)) {
				contador_secuencias++;
			}
			
		}
		
		return contador_secuencias;
    
}


function validarOblicuas(dna){
    contador_secuencias = 0;
    n = dna.length -1;
    cadenaTemporal1 = '';
    cadenaTemporal2 = '';
    contador1 = 0;
    contador2 = n;
    for(var i = 0; i < dna.length; i++){
        cadenaTemporal1 = cadenaTemporal1+dna[i][contador1];
        cadenaTemporal2 = cadenaTemporal2+dna[i][contador2];
        contador1++;
        contador2--;
    }
    if(encuentraSecuencia(cadenaTemporal1)){
        contador_secuencias++;
    }
    if(encuentraSecuencia(cadenaTemporal2)){
        contador_secuencias++;
    }
    return contador_secuencias;
}


function encuentraSecuencia(cad){
    contadorLetras = 1;
    letraActual = '0';
    for (var i = 0; i < cad.length; i++) {
        //validar si son iguales
        if(letraActual == cad[i]){
            contadorLetras++;
        }else{
            contadorLetras = 1;
            
        }
        letraActual = cad[i];
        if(contadorLetras == 4){
            
            return true;
            
        }
    }
    
    return false;
    
    
}


function validaADN(dna) {
		 numeroFilas = 0;
		 numeroColumnas = 0;
		
		numeroFilas = dna.length;
		
		if(numeroFilas > 3){
		
    for(var i = 0; i < dna.length; i++){
			
			if(dna[i].length != numeroFilas) {
				return false;
			}
			
			
		}

		return true;
		}
		return false;
	}
	