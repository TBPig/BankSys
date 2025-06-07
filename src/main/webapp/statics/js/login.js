// 简单的输入框高亮和回车提交
document.addEventListener('DOMContentLoaded', function () {
    const inputs = document.querySelectorAll('.login-form input, .login-form select');
    inputs.forEach(input => {
        input.addEventListener('focus', () => {
            input.style.boxShadow = '0 0 0 2px #74ebd5';
        });
        input.addEventListener('blur', () => {
            input.style.boxShadow = 'none';
        });
    });

    // 回车自动提交
    document.querySelector('.login-form').addEventListener('keydown', function (e) {
        if (e.key === 'Enter') {
            this.submit();
        }
    });
});