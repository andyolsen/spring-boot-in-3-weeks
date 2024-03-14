class RestClient {

    static baseUrl = "http://localhost:8080/full"

    static getAllProducts()  {
        const url = `${RestClient.baseUrl}/products`
        const promise1 = fetch(url)

        const promise2 = promise1.then(response => {
            return response.json()
        })
        return promise2
    }

    static async getProduct(id) {
        const url = `${RestClient.baseUrl}/products/${id}`
        const response = await fetch(url)
        return response.json()
    }

    static insertProduct(product)  {
        const url = `${RestClient.baseUrl}/products`
        return fetch(
            url,
            {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(product)
            }
        )
    }
}