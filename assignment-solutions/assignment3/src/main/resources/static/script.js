var baseAddress = 'productSuggestions'

async function getAll() {
    const url = baseAddress;
    const response = await fetch(url)
    await displayResponse(response)
}

async function getById() {
    const id = prompt('Please enter an ID')
    const url = `${baseAddress}/${id}`;
    const response = await fetch(url)
    await displayResponse(response)
}

async function insert() {
    const descr = prompt('Please enter the Description')
    const price = prompt('Please enter the Recommended Price')
    const sales = prompt('Please enter the Estimated Annual Sales')
    const obj = {description: descr, recommendedPrice: Number(price), estimatedAnnualSales: Number(sales)}

    const url = baseAddress;
    const response = await fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json', 'Accept': 'application/json' },
        body: JSON.stringify(obj)
    })
    await displayResponse(response)
}

async function modifyPrice() {
    const id = prompt('Please enter an ID')
    const price = prompt('Please enter the new Recommended Price')

    const url = `${baseAddress}/modifyPrice/${id}?newPrice=${price}`;
    const response = await fetch(url, {method: 'PUT'})
    displayResponse(response)
}

async function modifySales() {
    const id = prompt('Please enter an ID')
    const sales = prompt('Please enter the new Estimated Annual Sales')

    const url = `${baseAddress}/modifySales/${id}?newSales=${sales}`;
    const response = await fetch(url, {method: 'PUT'})
    displayResponse(response)
}

async function deleteAll() {
    const url = `${baseAddress}`;
    const response = await fetch(url, {method: 'DELETE'})
    displayResponse(response)
}

function displayResponse(response) {
    const displayArea = document.querySelector('#displayArea')

    const status = response.status;
    response.json()
            .then(body => displayArea.innerHTML = `Status: ${status}<br>Body: ${JSON.stringify(body)}`)
            .catch(err => displayArea.innerHTML = `Status: ${status}<br>Body: empty`)
}