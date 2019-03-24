node{
properties([parameters([string(defaultValue: '', description: 'Docker host', name: 'IP ', trim: false), string(defaultValue: 'latest', description: 'version of the app ', name: 'VER', trim: false), string(defaultValue: '4000', description: 'What port would you like to run ', name: 'PORT', trim: false)])])        try{
             sh "ssh root@${IP} docker rm -f Flaskex"
         }
         catch(exec){
             sh "echo container deleted"
         }   
        sh "ssh docker run -d Flaskex -p  ${PORT}:4000 farrukhsadyrkov/flaskex:${VER}"
    
    }
}