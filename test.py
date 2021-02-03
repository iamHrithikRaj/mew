import requests

BASE = "http://127.0.0.1:5000/"

data = [
    {
    "name" : "Learn Flask with me",
    "views" : 100000,
    "likes" : 20000
    },
    {
    "name" : "DIY makeup tutorial",
    "views" : 65879655,
    "likes" : 67546
    },
    {
    "name" : "Meme review",
    "views" : 1241351,
    "likes" : 587
    }
]

for i in range(len(data)):
   response = requests.put(BASE + "video/" + str(i), data[i])
   print(response.json())

# response = requests.delete(BASE + "video/0")
# print(response)
# input()
response = requests.get(BASE + "video/2" )
print(response.json())

response = requests.patch(BASE + "video/2", {"likes" : 6969})