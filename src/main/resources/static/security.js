const myAxios = axios;

myAxios.defaults.baseURL = "http://localhost:8080";

const helloBtn = document.querySelector("#btn-hello");

const loginBtn = document.querySelector("#login-btn");

let helloBtnUrl = helloBtn.addEventListener('click', () => {
    myAxios.get("/hello",  { headers: { Authorization: "Test Authorization" } }).then((response) => {
        console.log("status: ", response);
    });
})

loginBtn.addEventListener('click', () => {

    let loginName = document.querySelector("#name").value;
    let loginPassword = document.querySelector("#password").value;

    let params = new URLSearchParams();
    params.append('username', loginName);
    params.append('password', loginPassword);

    // console.log(params)

    // console.log(loginName, loginPassword);

    // myAxios.get("/users", {params: {username: loginName, loginPassword: loginPassword}}).then(response => {
    //     console.log(response)
    // })
    myAxios.post("/login", params).then(response => {
        console.log(response)
    })
})
