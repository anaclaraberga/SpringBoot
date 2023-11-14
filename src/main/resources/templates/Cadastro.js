const URL = 'http://localhost:8080'

const api = await fetch(`${URL}/user`,{method: 'POST',
body: JSON.stringify(data)}
)

api.json.then((data) => console.log(data))

