# Contents
Here are the Configuration Files of this Application

## GlobalJpaConfiguration
Its main purpose is to enable the Auditing functionality of Spring Data. It also registers the AuditorAware interface
to resolve username for ``@LastModifiedBy`` and ``@CreatedBy``

## GlobalWebConfiguration
Mainly used to register the swagger-ui.html so it'll get served. It tells Spring also to redirect every Invocation
where it can't find any Request Handler to the index.html file (so that Angular is working like supposed, else after a
page refresh there would be the 404 Not found screen)

It also adds Cors to the Application as else Angular couldn't make any Http Requests to the backend

## GlobalSecurityConfiguration
This is a sample Configuration on how to use JWT tokens in an Web Application. It also defines the routes which are
secured

## Swagger Configuration
Simple Configuration so that Swagger is documenting all of our endpoints. It also replaces the Pageable interface with a
more sufficient one
