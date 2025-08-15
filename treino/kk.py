import requests

params = {
    "cpf": "019.108.126-41",  
    "token": "035bd87fe45246a2fdba9f8bcf1d24c027a1e914"
}

url = 'https://desafio-endpoint-hashcode-n2.onrender.com/passo4'
response = requests.get(url, params=params)

print(response.status_code)
print(response.text)
