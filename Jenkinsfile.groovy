node{
properties([parameters([string(defaultValue: 'IP ', description: 'Please enter IP address for website', name: '127.0.0.1', trim: false), string(defaultValue: 'version ', description: 'Please select version ', name: 'VER', trim: false)])])    stage("Run container"){
        try{
             sh "ssh root@${IP} docker rm -f Flaskex"
         }
         catch(exec){
             sh "echo container deleted"
         }   
        sh "ssh docker run -d Flaskex -p 4400:4000 farrukhsadyrkov/flaskex:${VER}"
    
    }
}