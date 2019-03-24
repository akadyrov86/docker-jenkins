node{
    properties([parameters([run(description: 'Please enter IP address to run website', filter: 'ALL', name: '127.0.0.1', projectName: 'IP ')])])
    stage("Run container"){
        try{
             sh "ssh root@${IP} docker rm -f Flaskex"
         }
         catch(exec){
             sh "echo container deleted"
         }   
        sh "ssh docker run -d Flaskex -p 6000:4000 farrukhsadyrkov/flaskex"
    
    }
}