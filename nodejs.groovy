job('NodeJS Job') {
    scm {
        git('https://github.com/renkataoka/devops_sample_nodejs.git') { node ->
            node / gitConfigName('renkataoka')
            node / gitConfigEmail('530lotus@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs_v14')
    }
    steps {
        shell("npm install")
        shell("npm test")
    }
}