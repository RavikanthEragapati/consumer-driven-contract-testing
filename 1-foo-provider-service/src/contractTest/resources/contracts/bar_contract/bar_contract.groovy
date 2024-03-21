package contracts

import groovy.transform.Field

@Field
final String UUID_REGEXP = '^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}\$'

@Field
final String ALPHA_NUMERIC_REGEXP = '^[A-Za-z0-9]+$'

@Field
final String ALPHA_NUMERIC_UNDERSCORE_REGEXP = '^[A-Za-z\\d\\-_\\s]+\$'



org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        urlPath('/api/foo/greeting') {
            queryParameters {
                parameter('id', '3ecbaa20-3157-49a7-b8bf-eeeca9170de4')
            }
        }
    }
    response {
        println response.body
        status OK()
        body(
                "id" : '3ecbaa20-3157-49a7-b8bf-eeeca9170de4',
                "greeting" : 'Foo says - Hello'

        )
        headers {
            contentType('application/json')
        }
    }
}