This a demo to understand  how to use pulumi with floci

# FIRST
 - install pulumi 
    - export PATH=$PATH:/the/path
    - follow the guide to create a new mkdir for the specific provider
     - pulumi login --local
     - create your key

# install floci
    - floci start
    - depending on your provider
        - export proviver-key-id = mock_key
        - export provider-secret-access = mock_secret
        - export provider-default-region = "whatever region u are in"

- pulumi config set provider:variable <depends your own provider> <check pulumi guid or look online for more details>
- make sure you declare the services in your main.py
- pulumi up

# if on codespace
    - floci -> https://<codespace name_someotherstuff check when you click the link when you floci start>-4566.app.github.dev/
    - floci ui -> https://<that you url you saw when you clicked the link, use it just change the number>-4500.app.github.dev/

# Run it when you leave
    - ge
