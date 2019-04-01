
cf push
cf bind-service quotes-oidc sso -c oidc-client-config.json
cf scale quotes-oidc -i 1