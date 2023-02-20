fetch('/applyRequest/{id}')
    .then(response => response.json())
    .then(data => {
        d
        const select = document.getElementById("questionList");
        data.forEach(question => {
            const option = document.createElement('option');
            option.value = question.id;
            option.questionContent = question.text;
            select.appendChild(option);
        });
    });
